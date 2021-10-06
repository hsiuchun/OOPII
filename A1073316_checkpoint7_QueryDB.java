import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

public class A1073316_checkpoint7_QueryDB {
    //Description : the driver description of mysql
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    //Description : the protocol description of mysql
    private static final String PROTOCOL = "jdbc:mysql:";
    //Description : the obstacle set queried from database.
    private static ArrayList<Integer[]> data;
    //Description : the filename of obstacle image queried from database.
    private static HashMap<Integer, String> typeChar;
    //Description : the ID of the map in database;
    private static String mapID;
    //Description : the sand set queried from database.
    private static ArrayList<Integer[]> sands;
    public A1073316_checkpoint7_QueryDB(String mapID){
        this.data  = new ArrayList<Integer[]>();
        this.sands = new ArrayList<Integer[]>();
        this.typeChar = new HashMap<Integer, String>();
        this.mapID = mapID;
        queryData(this.data, this.typeChar);
        querySand(this.sands);
    }

    private static void queryData(ArrayList<Integer[]> data,HashMap<Integer, String> typeChar) {
    /*********************************The Past TODO (Checkpoint2)********************************
     * 
     * TODO(Past) Querying the barrier location from the server, and set it into Arraylist.
     * 
     * TODO(Past) Querying the bar_type and the corresponding file_name from the server, and set it into HashMap.
     * 
     * Hint:  for ckp2 to after, you need replace querying  column "file_name" with querying  column "display". 
     * 
     **********************************The End of the TODO***************************************/

     /********************************************************************************************
     START OF YOUR CODE
     ********************************************************************************************/
    try{
        Class.forName(DRIVER).getDeclaredConstructor().newInstance();
    }
    catch(Exception e){
        System.out.println("Fail to load driver...");
        e.printStackTrace(System.err);
        System.exit(0);
    }
    String url=PROTOCOL+"//140.127.220.220:3306/CHECKPOINT";
    String user="checkpoint";
    String password="ckppwd";
    Connection conn=null;
    try{
        conn=DriverManager.getConnection(url, user, password);
    }
    catch(Exception e){
        System.out.println("Incorrect username or password...");
        e.printStackTrace(System.err);
        System.exit(0);
    }
    ResultSet rs = null;
    try {
        Statement s=conn.createStatement();
        // String sql1="SELECT DISTINCT * FROM map WHERE map_id = "+mapID;
        // rs=s.executeQuery(sql1);

        // if(!rs.next()){
        //     System.exit(0);
        // }
        // int WIDTH = rs.getInt("width");
        // int HEIGHT = rs.getInt("height");
        
        // rs.close();

        //Get barrier location from barrier table
        String sql2="SELECT DISTINCT barrier.row_idx,barrier.column_idx,barrier.bar_type FROM barrier,barrier_type,map WHERE barrier.map_id = map.map_id AND barrier.map_id = "+mapID+" AND barrier.bar_type = barrier_type.bar_type ORDER BY barrier.row_idx,barrier.column_idx ASC";
        rs=s.executeQuery(sql2);
        
        while(rs.next()){
            // if(rs.getInt("barrier.row_idx")>0 && rs.getInt("barrier.row_idx")<=HEIGHT && rs.getInt("barrier.column_idx")>0 && rs.getInt("barrier.column_idx")<=WIDTH){
                Integer[] loc={rs.getInt("barrier.row_idx"),rs.getInt("barrier.column_idx"),rs.getInt("barrier.bar_type")};
                data.add(loc);
            // }
            
        }

        rs.close();

        //Get barrier type information from barrier_type table
        String sql3="SELECT DISTINCT * FROM barrier_type"; 
        rs=s.executeQuery(sql3);
        
        while(rs.next()){
            typeChar.put(rs.getInt("bar_type"),rs.getString("file_name"));
        }
        
        rs.close();
        conn.close();

    } catch (Exception e) {
        e.printStackTrace(System.err);
        System.exit(0);
    } 
    /********************************************************************************************
     END OF YOUR CODE
     ********************************************************************************************/
    }
    private static void querySand(ArrayList<Integer[]> sands) {
    /*********************************The TODO This Time (Checkpoint7)***************************
     * 
     * TODO(1) Querying the map size and the sand location from the server, and set it into Arraylist.
     * 
     **********************************The End of the TODO***************************************/

     /********************************************************************************************
     START OF YOUR CODE
     ********************************************************************************************/
    try{
        Class.forName(DRIVER).getDeclaredConstructor().newInstance();
    }
    catch(Exception e){
        System.out.println("Fail to load driver...");
        e.printStackTrace(System.err);
        System.exit(0);
    }
    String url=PROTOCOL+"//140.127.220.220:3306/CHECKPOINT";
    String user="checkpoint";
    String password="ckppwd";
    Connection conn=null;
    try{
        conn=DriverManager.getConnection(url, user, password);
    }
    catch(Exception e){
        System.out.println("Incorrect username or password...");
        e.printStackTrace(System.err);
        System.exit(0);
    }
    ResultSet rs = null;
    try {
        Statement s=conn.createStatement();
        String sql1="SELECT DISTINCT * FROM map WHERE map_id = "+mapID;
        rs=s.executeQuery(sql1);

        if(!rs.next()){
            System.exit(0);
        }
        int WIDTH = rs.getInt("width");
        int HEIGHT = rs.getInt("height");
        
        rs.close();

        //Get barrier location from barrier table
        String sql2="SELECT DISTINCT row_idx,column_idx FROM sand WHERE sand.map_id = "+mapID;
        rs=s.executeQuery(sql2);
        
        while(rs.next()){
            // if(rs.getInt("barrier.row_idx")>0 && rs.getInt("barrier.row_idx")<=HEIGHT && rs.getInt("barrier.column_idx")>0 && rs.getInt("barrier.column_idx")<=WIDTH){
                Integer[] loc={rs.getInt("row_idx"),rs.getInt("column_idx")};
                sands.add(loc);
            // }
            
        }

        rs.close();
        conn.close();

    } catch (Exception e) {
        e.printStackTrace(System.err);
        System.exit(0);
    } 
    /********************************************************************************************
     END OF YOUR CODE
    ********************************************************************************************/
    }
    public ArrayList getObstacle(){
        return this.data;
    }
    public void setObstacle(ArrayList<Integer[]> data){
        this.data = data;
    }
    public String getMapID(){
        return this.mapID;
    }
    public void setMapID(String mapID){
        this.mapID = mapID;
    }
    public HashMap getObstacleImg(){
        return this.typeChar;
    }
    public void setObstacleImg(HashMap<Integer, String> typeChar){
        this.typeChar = typeChar;
    }
    public ArrayList getSands(){
        return this.sands;
    }
    public void setSands(ArrayList<Integer[]> sands){
        this.sands = sands;
    }
}
