package org.example;

import org.example.dao.ClientDao;
import org.example.dao.ProjectDao;
import org.example.dao.ProjectWorkerDao;
import org.example.dao.WorkerDao;
import org.example.dto.ClientDto;
import org.example.dto.ProjectDto;
import org.example.dto.ProjectWorkerDto;
import org.example.dto.WorkerDto;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public Main() {
    }

    public static void main(String[] args) throws SQLException {
        List<WorkerDto> workers = new ArrayList<>();
        workers.add(new WorkerDto( "Alex", LocalDate.parse("2000-01-01"), "Junior", 900));
        workers.add(new WorkerDto(  "Nic", LocalDate.parse("1995-02-01"), "Senior", 5100));
        workers.add(new WorkerDto( "Nelly", LocalDate.parse("1990-03-01"), "Middle", 2000));
        WorkerDao worker = new WorkerDao();
        worker.insertWorker(workers);

        List<ClientDto> clients = new ArrayList<>();
        clients.add(new ClientDto("Alex"));
        clients.add(new ClientDto("Bro"));
        clients.add(new ClientDto("Tro"));
        ClientDao cl = new ClientDao();
        cl.insertClient(clients);

        List<ProjectDto> projects = new ArrayList<>();
        projects.add(new ProjectDto(1, LocalDate.parse("2020-01-01"), LocalDate.parse("2023-01-01")));
        projects.add(new ProjectDto(2, LocalDate.parse("2020-01-01"), LocalDate.parse("2023-01-01")));
        projects.add(new ProjectDto(3, LocalDate.parse("2019-01-01"), LocalDate.parse("2020-01-01")));
        ProjectDao prj = new ProjectDao();
        prj.insertProject(projects);

        List<ProjectWorkerDto> prjWorker = new ArrayList<>();
        prjWorker.add(new ProjectWorkerDto(1, 2));
        prjWorker.add(new ProjectWorkerDto(2, 1));
        prjWorker.add(new ProjectWorkerDto(3,3));
        ProjectWorkerDao prjw = new ProjectWorkerDao();
        prjw.insertProjectWorker(prjWorker);


    }




}