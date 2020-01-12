package view.DatabaseBrowser;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;

import com.microsoft.sqlserver.jdbc.SQLServerResultSet;

import dbManipulation.DBManipulation;
import dbType.DatabaseType;

public class CustomTreeModel extends DefaultTreeModel
{
	private static final long serialVersionUID = 1L;
	DBManipulation DBM = null;
	Connection conn = null;
	TreeNode root = null;
	ResultSet rs = null;
	
	Vector<String> tableNames = new Vector<String>();
	Vector<ResultSetMetaData> tables = new Vector<ResultSetMetaData>();
	ResultSetMetaData rsmd = null;
	DatabaseMetaData dbmd = null;
	
	public CustomTreeModel(TreeNode root)
	{
		super(root);
		this.root = root;
		DBM = new DBManipulation(DatabaseType.MsSQL_JDBC, "78.28.157.8", "1433", "PIS2017", "EtfPIS2017G3", "EtfPIS2017G36714");
		conn = DBM.getDbConnection();
		
		try
		{
			dbmd = conn.getMetaData();
			rs = dbmd.getTables(null, null, null, new String[] { "TABLE" });
			
			while(rs.next())
			{
				java.sql.Statement stmt = this.conn.createStatement(SQLServerResultSet.TYPE_SCROLL_INSENSITIVE, SQLServerResultSet.CONCUR_READ_ONLY);
				ResultSet res = stmt.executeQuery("SELECT * FROM " + rs.getString("TABLE_NAME"));
				tables.add(res.getMetaData());
				
				/******************************************************/
				System.out.println(rs.getString("TABLE_NAME"));
				
				tableNames.addElement(rs.getString("TABLE_NAME"));				
			}
			
			System.out.println(rs);
		}
		
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public boolean isLeaf(Object node)
	{
		if (node == getRoot())
		{
			return false;
		} else
		{
			for (int i = 0; i < tableNames.size(); i++)
			{
				if (tableNames.elementAt(i) == node)
				{
					return false;
				}
			}
		}
		return true;
	}

	@Override
	public int getChildCount(Object parent)
	{
		for (int i = 0; i < tableNames.size(); i++)
		{
			if (parent == tableNames.get(i))
			{
				try
				{
					return tables.get(i).getColumnCount();
				}
				catch (SQLException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return tableNames.size();
	}
	
	@Override
	public Object getChild(Object parent, int index)
	{
		try
		{
			if (parent == getRoot())
			{

				System.out.println(tableNames.elementAt(index));
				return tableNames.elementAt(index);

			} else
			{
				for (int i = 0; i < tableNames.size(); i++)
				{
					if (tableNames.get(i) == parent)
					{
						return tables.elementAt(i).getColumnName(index + 1);
					}
				}
			}

		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}


	
}
