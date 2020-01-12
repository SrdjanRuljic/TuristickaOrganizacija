package dbConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import dbType.DatabaseType;

/**
 * Klasa zaduzena za realizaciju apstraktne metode {@link #getConnection(String, String, String, String, String)}.
 * Prosljedjuju se parametri koji su potrebni za kreiranje konekcije na MySQL server sa jdbc konektorom.
 * @author ZoranaS
 *
 */
public class MySQLConnection extends DBConnection
{

	public MySQLConnection(DatabaseType dbType, String address, String port, String dbName, String username, String password)
	{
		super(dbType, address, port, dbName, username, password);
		
	}

	@Override
	public Connection getConnection(String address, String port, String dbName, String user, String password) 
	{

		this.type = DatabaseType.MySQL;
		this.driver = "com.mysql.jdbc.Driver";
		this.address = address.trim();
		this.port = port;
		this.dbName = dbName.trim();

		if (port != null)
		{
			this.fullAddress = this.address + ":" + port.trim();
		}
		else
		{
			this.fullAddress = this.address;
		}

		this.url = "jdbc:mysql://" + this.fullAddress + "/";

		if (!isConnectionOpen())
		{
			this.user = user.trim();
			this.password = password.trim();
			this.url += this.dbName;
			try
			{
				Class.forName(this.driver);

				Properties properties = new Properties();
				properties.put("user", this.user);
				properties.put("password", this.password);
				properties.put("useUnicode", "true");
				properties.put("characterEncoding", "ISO8859_2");

				conn = DriverManager.getConnection(this.url, properties);

				return conn;
			}
			catch (ClassNotFoundException e)
			{
				ErrorHandlerFunction(null, e.getMessage());
			}
			catch (SQLException e)
			{
				ErrorHandlerFunction(null, e.getMessage());
			}

			return null;
		}

		return conn;
	}

}
