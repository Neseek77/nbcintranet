import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.sql.*;
import javax.swing.*;
import java.io.*;

public class ExecuteNonQ{
Connection con=null;
public ExecuteNonQ(){
    ConnectionString ob=new ConnectionString();
    String Name,Type,Usr,Pwd;
    Name=ob.CNName();
    Type=ob.CNType();
    Usr=ob.UsrName();
    Pwd=ob.Password();
        try{
              Class.forName(Name);
              con=DriverManager.getConnection(Type,Usr,Pwd);
        }catch(Exception e){e.getLocalizedMessage();}
}   
public void updateQuery(String TBLName,String SQLField,String criterial,String value){
        try{
              Statement s=con.createStatement();
              ResultSet rs = s.executeQuery("UPDATE " + TBLName +" SET "+SQLField+" WHERE "+criterial+ "='"+ value+ "'");    
              rs.close();
       }catch(Exception e){e.getLocalizedMessage();}
}    

public void insertQuery(String TBLName,String ValueFieldOnly){
       try{
              Statement s=con.createStatement();
              ResultSet rs = s.executeQuery("INSERT INTO " + TBLName +" VALUES(" + ValueFieldOnly + ")");
              rs.close();
       }catch(Exception e){e.getLocalizedMessage();}
}
public void insertQueryCustomize(String TBLName,String SQLwithTableField){
       try{
              Statement s=con.createStatement();
              ResultSet rs = s.executeQuery("INSERT INTO " + TBLName + SQLwithTableField );
              rs.close();
       }catch(Exception e){e.getLocalizedMessage();}
}
public ResultSet SelectQueryAll(String TABLENAME){
    ResultSet rs=null;
       try{
            Statement s=con.createStatement();
            rs=s.executeQuery("SELECT * FROM " +TABLENAME);
    }catch(Exception e){e.getLocalizedMessage();}
return rs;
}

public ResultSet SelectQueryAllWhere(String TABLENAME,String Fieldname,String VALUE){
    ResultSet rs=null;
       try{
            Statement s=con.createStatement();
            rs=s.executeQuery("SELECT * FROM " +TABLENAME + " WHERE "+Fieldname+"='"+ VALUE+ "'");
    }catch(Exception e){e.getLocalizedMessage();}
return rs;
}

public ResultSet SelectQueryByField(String SELECTFIELD,String TABLENAME){
    ResultSet rs=null;
       try{
            Statement s=con.createStatement();
            rs=s.executeQuery("SELECT " +SELECTFIELD+ " FROM " +TABLENAME);
    }catch(Exception e){e.getLocalizedMessage();}
return rs;
}

public ResultSet SelectQueryByFieldWithCondition(String SELECTFIELD,String TABLENAME,String FIELDNAME,String VALUE){
    ResultSet rs=null;
       try{
            Statement s=con.createStatement();
            rs=s.executeQuery("SELECT " + SELECTFIELD + " FROM " +TABLENAME+ " WHERE "+ FIELDNAME + "='"+ VALUE+ "'");
    }catch(Exception e){e.getLocalizedMessage();}
return rs;
}

public ResultSet Empty(String CompleteSQL){
    ResultSet rs=null;
       try{
            Statement s=con.createStatement();
        rs=s.executeQuery(CompleteSQL);
    }catch(Exception e){e.getLocalizedMessage();}
return rs;
}

public ResultSet Emptyme(String CompleteSQL){
    ResultSet rs=null;
       try{
        Statement stmt=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);;
        rs=stmt.executeQuery(CompleteSQL);
    }catch(Exception e){e.getLocalizedMessage();}
return rs;
}

public ResultSet SelectJoin(String SELECTFIELDFROMBOTHTABLE,String TABLENAME1,String TABLENAME2,String CONDITIONTABLE1,String CONDITIONTABLE2){
    ResultSet rs=null;
       try{
            Statement s=con.createStatement();
            rs=s.executeQuery("SELECT " + SELECTFIELDFROMBOTHTABLE + " FROM " +TABLENAME1+ " JOIN "+ TABLENAME2 +" ON "+CONDITIONTABLE1+"="+CONDITIONTABLE2);
    }catch(Exception e){e.getLocalizedMessage();}
return rs;

/*
 SELECT Customers.FirstName, Customers.LastName, SUM(Sales.SaleAmount) AS SalesPerCustomer
FROM Customers JOIN Sales
ON Customers.CustomerID = Sales.CustomerID
GROUP BY Customers.FirstName, Customers.LastName 
 */
}


}
   