package jdbc1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by MacUser on 06.06.19.
 */
public class TableNameDao {

    public Collection<Human> findAll() throws SQLException{
        List<Human> testObj = new ArrayList<Human>();
        Connection conn = ConnectToDB.connectionToDB();
        Human human = null;
        PreparedStatement ps = conn.prepareStatement("SELECT * FROM Clients");
        try{
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                human = new Human(rs.getInt("id"), rs.getString("name"), rs.getInt("age"));
                testObj.add(human);
            }
        } catch (Exception e){

        }finally {
            ps.close();
            ConnectToDB.closeConnection(conn);
        }
        return testObj;
    }

    public Human findById(int id) throws SQLException{
        Human human = null;
        Connection conn = ConnectToDB.connectionToDB();
        PreparedStatement ps = conn.prepareStatement("SELECT * FROM Clients WHERE id = ?");
        try{
            if(checkId(id)){
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            human = new Human(rs.getInt("id"), rs.getString("name"), rs.getInt("age"));

            }
        }catch (SQLException e){

        }finally {
            ps.close();
            ConnectToDB.closeConnection(conn);
        }
        return human;
    }

    private boolean checkId(int id) throws SQLException{
        Connection conn = ConnectToDB.connectionToDB();
        PreparedStatement ps = conn.prepareStatement("SELECT id FROM Clients");
        try{
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                if(id == rs.getInt("id")){
                    return true;
                }
            }
        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }finally {
            ps.close();
            ConnectToDB.closeConnection(conn);
        }
        System.out.println("ERROR: ID not found!");
        return false;
    }

    public boolean addHuman(Human test) throws SQLException{
        Connection conn = ConnectToDB.connectionToDB();
        PreparedStatement ps = conn.prepareStatement("INSERT INTO Clients (name, age) VALUES(?, ?)");
        try{
            ps.setString(1, test.getName());
            ps.setInt(2, test.getAge());
            ps.executeUpdate();
            return true;
        }catch (SQLException e){
            return false;
        }finally {
            ps.close();
            ConnectToDB.closeConnection(conn);
        }
    }

    public boolean updateHuman(int id, String newName, int newAge) throws SQLException{
        Connection conn = ConnectToDB.connectionToDB();
        PreparedStatement ps = conn.prepareStatement("UPDATE Clients SET name = ?, age =? WHERE id = ?");
        try{
            if(checkId(id)) {
                ps.setString(1, newName);
                ps.setInt(2, newAge);
                ps.setInt(3, id);
                ps.executeUpdate();
                return true;
            }
        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }finally {
            ps.close();
            ConnectToDB.closeConnection(conn);
        }
        return false;
    }

    public boolean deleteHuman(int id) throws SQLException{
        Connection conn = ConnectToDB.connectionToDB();
        PreparedStatement ps = conn.prepareStatement("DELETE FROM Clients WHERE id = ?");
        try{
            if(checkId(id)) {
                ps.setInt(1, id);
                ps.executeUpdate();
                return true;
            }
        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }finally {
            ps.close();
            ConnectToDB.closeConnection(conn);
        }
        return false;
    }
}
