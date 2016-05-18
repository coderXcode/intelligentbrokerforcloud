
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class querryrunner 
{
    
    public static void createtable(String query) throws Exception
    {
        
        Connection con=db.createConnection();
          PreparedStatement ps1=con.prepareStatement(query);
             //   System.out.println("hereee7788");   
                ps1.execute();
        
    }
    public static void entryofrow(ArrayList<String> al)
    {
          Connection con;
          PreparedStatement ps;
    
           con=db.createConnection();
           //System.out.println("here 1");
            String inLogin="";
           try{
         //  System.out.println("here 3");
           inLogin="Insert into manaks.cloud values (?,?,?,?,?,?,?,?)";
          
           for(String k:al)
           {
           //System.out.println("here 2");
           ps=con.prepareStatement(inLogin);
           StringTokenizer st=new StringTokenizer(k);
           // System.out.println("here 2");
           int run=1;
           System.out.println(k);
               while(st.hasMoreTokens())
               {
                   ps.setString(run,st.nextToken().toLowerCase());
                   run=run+1;
               }
            
               int u=ps.executeUpdate();
            
           }
          /* ps.setString(1,uname);
            ps.setString(2,upass);
            ps.setString(3,uadd);
            ps.setString(4,unumb);
            ps.setString(5,umail);*/
            //System.out.println("here 4");
           
           }
           catch(SQLException e)
           {
               
           }
    
        
    }
    
}
