package org.example;

import org.example.result_select_classes.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseQueryService {
    private Connection connection;

    public DatabaseQueryService(){
        try {
            connection = DatabaseStorage.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void connectionClose(){
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<MaxProjectCountClient> findMaxProjectsClient() throws IOException {
        List<MaxProjectCountClient> maxProjectclientList = new ArrayList<>();
        String findMaxProjectsClientQuery = new String(Files.readAllBytes(Paths.get("src/main/resources/sql/find_max_projects_client.sql")));
        try(PreparedStatement stmt = connection.prepareStatement(findMaxProjectsClientQuery)) {
            ResultSet result = stmt.executeQuery();
            while (result.next()){
                maxProjectclientList.add(new MaxProjectCountClient(result.getString(1), result.getInt(2)));
            }
            return maxProjectclientList;
        }catch (SQLException exception){
            return maxProjectclientList;
        }

    }

    public List<LongestProject> findLongestProject() throws IOException {
        List<LongestProject> longestProjectList = new ArrayList<>();
        String findLongestProjectQuery = new String(Files.readAllBytes(Paths.get("src/main/resources/sql/find_longest_project.sql")));
        try(PreparedStatement stmt = connection.prepareStatement(findLongestProjectQuery)){
            ResultSet result = stmt.executeQuery();
            while (result.next()){
                longestProjectList.add(new LongestProject(result.getInt(1), result.getInt(2)));
            }
            return longestProjectList;
        }catch (SQLException exception){
            return longestProjectList;
        }
    }

    public List<MaxSalaryWorker> findMaxSalaryWorker() throws IOException{
        List<MaxSalaryWorker> maxSalaryWorkerList = new ArrayList<>();
        String findMaxSalaryWorkerQuery = new String(Files.readAllBytes(Paths.get("src/main/resources/sql/find_max_salary_worker.sql")));
        try(PreparedStatement stmt = connection.prepareStatement(findMaxSalaryWorkerQuery)){
            ResultSet result = stmt.executeQuery();
            while (result.next()){
                maxSalaryWorkerList.add(new MaxSalaryWorker(result.getString(1), result.getInt(2)));
            }
            return maxSalaryWorkerList;
        }catch (SQLException exception){
            return maxSalaryWorkerList;
        }
    }

    public List<YoungestEldestWorker> findYoungestEldestWorkers() throws IOException {
        List<YoungestEldestWorker> youngestEldestWorkerList = new ArrayList<>();
        String findYoungestEldestWorkersQuery = new String(Files.readAllBytes(Paths.get("src/main/resources/sql/find_youngest_eldest_workers.sql")));
        try (PreparedStatement stmt = connection.prepareStatement(findYoungestEldestWorkersQuery)){
            ResultSet result = stmt.executeQuery();
            while (result.next()){
                youngestEldestWorkerList.add(new YoungestEldestWorker(result.getString(1), result.getString(2), result.getDate(3)));
            }
            return youngestEldestWorkerList;
        }catch (SQLException exception){
            return youngestEldestWorkerList;
        }

    }

    public List<ProjectPrice> findProjectPrices() throws IOException {
        List<ProjectPrice> projectPriceList = new ArrayList<>();
        String findProjectPricesQuery = new String(Files.readAllBytes(Paths.get("src/main/resources/sql/print_project_prices.sql")));
        try(PreparedStatement stmt = connection.prepareStatement(findProjectPricesQuery)){
            ResultSet result = stmt.executeQuery();
            while (result.next()){
                projectPriceList.add(new ProjectPrice(result.getInt(1), result.getInt(2)));
            }
            return projectPriceList;
        }catch (SQLException exception){
            return projectPriceList;
        }
    }



}
