package com.design.structural;

interface DatabaseConnector {
	void connect(String app);
}

class MySqlDataBaseConnector implements DatabaseConnector {
	
	@Override
	public void connect(String app) {
		System.out.println("MySql Database Connection :"+app);
		
	}
}

class MongoDBDataBaseConnector implements DatabaseConnector{
	
	@Override
	public void connect(String app) {
		System.out.println("Mongo Databae Connector :"+app);
		
	}
}

interface Database {
	void executeQuery(String query);
}

class MySqlDatabase implements Database{
	
	private DatabaseConnector connector;
	
	public MySqlDatabase(DatabaseConnector connector) {
		this.connector=connector;
	}
	
	@Override
	public void executeQuery(String query) {
		connector.connect(query);
		
	}
}

class MongoDBDatabase implements Database{
	
	private DatabaseConnector connector;
	
	public MongoDBDatabase(DatabaseConnector connector) {
		this.connector=connector;
	}
	
	@Override
	public void executeQuery(String query) {
		connector.connect(query);
		
	}
}

public class BridgeDP_DatabaseConnector {

	public static void main(String[] args) {
		DatabaseConnector mySql=new MySqlDataBaseConnector();
		DatabaseConnector mongoDB=new MongoDBDataBaseConnector();
		
		Database mysqldb=new MySqlDatabase(mySql);
		mysqldb.executeQuery("select * from user ");
		
		Database mongodb=new MongoDBDatabase(mongoDB);
		mongodb.executeQuery("update employee set id=123 where roleid=34");

	}

}
