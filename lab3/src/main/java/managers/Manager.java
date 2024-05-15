/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package managers;

import an_mutya.lab3.ReactorRepository;
import an_mutya.lab3.ReactorService;
import entityForDataBase.ReadEntitiesForDB;
import entityForDataBase.ExportEntitiesToDB;
import an_mutya.lab3.TreeBuilder;

import javax.swing.tree.DefaultMutableTreeNode;

import handlers.JSONhandler;
import handlers.XMLhandler;
import handlers.YAMLhandler;
import org.hibernate.Session;
import reactor.ReactorStorage;
import reader.JsonReader;
import reader.XmlReader;
import reader.YamlReader;

import java.io.IOException;
import java.sql.SQLException;

/**
 * @author annamutovkina
 */
public class Manager {
    private ReadEntitiesForDB entities = new ReadEntitiesForDB();
    private SessionManager sessionManager = new SessionManager();
    public void closeSession(){
        sessionManager.closeSession();
    }
    public void agregationByCountry() {
        Session session = sessionManager.getSession();
        if (session == null) {
            session = sessionManager.createSession();
        }
            ReactorRepository reactorRepository = new ReactorRepository(session);
            ReactorService reactorService = new ReactorService(reactorRepository);
            reactorService.calculateReactorEnergyByCountryAndYear();
    }
    public void agregationByOwnerAndOperator() {

        Session session = sessionManager.getSession();
        if (session == null) {
            session = sessionManager.createSession();
        }
            ReactorRepository reactorRepository = new ReactorRepository(session);
            ReactorService reactorService = new ReactorService(reactorRepository);
            reactorService.calculateReactorEnergyByOwnerAndOperator();
    }
    public void agregationByRegion() {
        Session session = sessionManager.getSession();
        if (session == null) {
            session = sessionManager.createSession();
        }
            ReactorRepository reactorRepository = new ReactorRepository(session);
            ReactorService reactorService = new ReactorService(reactorRepository);
            reactorService.calculateReactorEnergyByRegionAndYear();
        }

    public void exportToDB() {
        ExportEntitiesToDB exportEntitiesToDB = new ExportEntitiesToDB();
        Session session = sessionManager.getSession();
        if (session == null) {
            session = sessionManager.createSession();
        }
        try {
            exportEntitiesToDB.extortStatusToDB(session, entities.readStatusForExcel());
            exportEntitiesToDB.extortRegionsToDB(session, entities.readRegionsForExcel());
            exportEntitiesToDB.extortCountriesToDB(session, entities.readCountriesForExcel());
            exportEntitiesToDB.extortOperatorsToDB(session, entities.readOperatorsForExcel());
            exportEntitiesToDB.extortOwnersToDB(session, entities.readOwnersForExcel());
            exportEntitiesToDB.extortReactorsToDB(session, entities.readReactorsForExcel());
            exportEntitiesToDB.extortKiumsToDB(session, entities.readKiumForExcel());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void loadFile(String path) {
        YAMLhandler yAMLhandler = new YAMLhandler(new YamlReader());
        JSONhandler jSONhandler = new JSONhandler(new JsonReader());
        XMLhandler xMLhandler = new XMLhandler(new XmlReader());
        yAMLhandler.setNext(jSONhandler);
        jSONhandler.setNext(xMLhandler);
        yAMLhandler.handleRequest(path);

    }

    public DefaultMutableTreeNode buildTree() {
        TreeBuilder treeBuilder = new TreeBuilder();
        return treeBuilder.buildTreeData();
    }

    public void deleteFiles() {
        ReactorStorage.INSTANCE.clearReactors();
    }
}
