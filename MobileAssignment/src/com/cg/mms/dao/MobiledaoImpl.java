package com.cg.mms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.cg.mms.exception.MobileException;
import com.cg.mms.model.Mobilemodel;
import com.cg.mms.model.Purchasemodel;
import com.cg.mms.utility.Jdbcutility;

public class MobiledaoImpl implements Mobiledao {

	Connection connection = null;
	Statement state = null;
	PreparedStatement statement = null;
	ResultSet resultSet = null;

	static Logger logger = Logger.getLogger(MobiledaoImpl.class);
	/**
	 * method      :  insertmobileDetails 
	 * argument   :  it's taking model object as an argument
	 * return type :  this method returns the details of mobile to the user 
	 * Author        :  Capgemini 
	 * Date            : 14-Jan-2019
	 * 
	 */
	@Override
	public int insertMobileDetails(Mobilemodel mobile) throws MobileException {
		
		logger.info("insert mobile details ");
		
		connection = Jdbcutility.getConnection();
		logger.info("connection object created ");
		int result = 0;

		try {
			statement = connection.prepareStatement(QueryMapper.InsertQuery);
			logger.debug("statement object created");
			statement.setInt(1, mobile.getMobileId());
			statement.setString(2, mobile.getName());
			statement.setDouble(3, mobile.getPrice());
			statement.setInt(4, mobile.getQuantity());
			result = statement.executeUpdate();
			logger.info("execute update called");

		} catch (SQLException e) {
			logger.error(e.getMessage());
			throw new MobileException("prepare statement not created");
		} finally {
			logger.info("in finally block");
			try {
				statement.close();
				logger.info("statement closed");
			} catch (SQLException e) {
				throw new MobileException("statement not closed");

			}

			try {
				connection.close();
				logger.info("connection closed");
			} catch (SQLException e) {
				throw new MobileException("connection not closed");
			}

		}

		return result;
	}

	@Override
	public List<Mobilemodel> selectAllMobile() throws MobileException {
		logger.info("selectallmobile details ");
		connection = Jdbcutility.getConnection();
		logger.info("connection object created ");
		List<Mobilemodel> list = new ArrayList<>();

		try {
			statement = connection.prepareStatement(QueryMapper.selectAllMobiles);
			logger.debug("statement object created");
			resultSet = statement.executeQuery();
			logger.info("execute query called");
			while (resultSet.next()) {
				int id = resultSet.getInt("mobileid");
				String name = resultSet.getString("name");
				Double price = resultSet.getDouble("price");
				Integer quantity = resultSet.getInt("quantity");

				Mobilemodel mobile = new Mobilemodel();
				mobile.setMobileId(id);
				mobile.setName(name);
				mobile.setPrice(price);
				mobile.setQuantity(quantity);
				list.add(mobile);

			}
		} catch (SQLException e) {
			logger.error(e.getMessage());
			throw new MobileException("prepare statement not created");
		} finally {
			logger.info("in finally block");
			try {
				resultSet.close();
				logger.info("resultset closed");
			} catch (SQLException e1) {
				throw new MobileException("resultSet not closed");
			}

			try {
				statement.close();
				logger.info("statement closed");
			} catch (SQLException e) {
				throw new MobileException("statement not closed");

			}

			try {
				connection.close();
				logger.info("connection closed");
			} catch (SQLException e) {
				throw new MobileException("connection not closed");
			}

		}

		return list;

	}

	@Override
	public int updateMobileQuantity(Purchasemodel purchase) throws MobileException {
		logger.info("mobile updated");
		connection = Jdbcutility.getConnection();
		logger.info("connection object created");
		boolean result = false;

		try {
			statement = connection.prepareStatement(QueryMapper.checkMobileId);
			logger.debug("statement object created");
			resultSet = statement.executeQuery();
			logger.info("execute query called");
			while (resultSet.next()) {
				Integer id = resultSet.getInt("mobileid");
				if (id.equals(purchase.getMobile_id())) {

					Integer id2 = resultSet.getInt("mobileid");
					Integer quantity = resultSet.getInt("quantity");

					if (quantity > 0) {
						statement = connection.prepareStatement(QueryMapper.updateQuantity);
						logger.debug("statement object created");
						statement.setInt(2, id2);
						statement.setInt(1, quantity - 1);
						statement.executeUpdate();
						System.out.println("Updated");

						statement = connection.prepareStatement(QueryMapper.insertPurchaseDetails);
						logger.debug("statement object created");
						statement.setString(1, purchase.getcName());
						statement.setString(2, purchase.getMailId());
						statement.setLong(3, purchase.getPhoneNumber());
						statement.setInt(4, purchase.getMobile_id());
						statement.executeUpdate();

						result = true;
						break;
					} else {
						System.out.println("Mobiles have been sold out. We don't have that type of mobiles to sell");
					}

				}

			}

			if (!result) {
				System.out.println("No mobile is present with the given id");
			}

		} catch (SQLException e) {
			throw new MobileException("Prepare statement not created");
		} finally {
			logger.info("in finally block");
			try {
				resultSet.close();
				logger.info("resultset closed");
			} catch (SQLException e1) {
				throw new MobileException("resultSet not closed");
			}

			try {
				statement.close();
				logger.info("statement closed");
			} catch (SQLException e) {
				throw new MobileException("statement not closed");

			}

			try {
				connection.close();
				logger.info("connection closed");
			} catch (SQLException e) {
				throw new MobileException("connection not closed");
			}

		}

		return 0;
	}

	@Override
	public List<Mobilemodel> MobileRange(Double range1, Double range2) throws MobileException {
		logger.info("mobile between range");
		List<Mobilemodel> list = new ArrayList<>();

		connection = Jdbcutility.getConnection();
		logger.info("connection object created");

		try {
			statement = connection.prepareStatement(QueryMapper.selectMobilerange);
			logger.debug("statement object created");
			statement.setDouble(1, range1);
			statement.setDouble(2, range2);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {

				int id = resultSet.getInt("mobileid");
				String name = resultSet.getString("name");
				Double price = resultSet.getDouble("price");
				Integer quantity = resultSet.getInt("quantity");
				Mobilemodel mobile = new Mobilemodel();
				mobile.setMobileId(id);
				mobile.setName(name);
				mobile.setPrice(price);
				mobile.setQuantity(quantity);
				list.add(mobile);

			}

		} catch (SQLException e) {
			throw new MobileException("prepare statement not created");
		} finally {
			logger.info("in finally block");
			try {
				resultSet.close();
				logger.info("resultset closed");
			} catch (SQLException e1) {
				throw new MobileException("resultSet not closed");
			}

			try {
				statement.close();
				logger.info("statement closed");
			} catch (SQLException e) {
				throw new MobileException("statement not closed");

			}

			try {
				connection.close();
				logger.info("connection closed");
			} catch (SQLException e) {
				throw new MobileException("connection not closed");
			}

		}

		return list;
	}

	@Override
	public int DeleteId(Integer id) throws MobileException {
		logger.info("deleted id");
		int result = 0;
		connection = Jdbcutility.getConnection();
		logger.info("connection object created");

		try {
			statement = connection.prepareStatement(QueryMapper.DeleteId);
			logger.debug("statement object created");

			statement.setInt(1,id);

			result = statement.executeUpdate();
			logger.info("statement executed");

		} catch (SQLException e) {
			throw new MobileException("prepare statement not created" + e);
		} finally {
			logger.info("in finally block");
			try {
				statement.close();
				logger.info("statement closed");
			} catch (SQLException e) {
				throw new MobileException("statement not closed" + e);

			}

			try {
				connection.close();
				logger.info("connection closed");
			} catch (SQLException e) {
				throw new MobileException("connection not closed");
			}

		}

		return result;
	}

}
