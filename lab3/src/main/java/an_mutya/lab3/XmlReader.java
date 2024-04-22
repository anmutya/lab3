/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package an_mutya.lab3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;



/**
 *
 * @author annamutovkina
 */
public class XmlReader implements FileReader{

    @Override
    public ArrayList<Reactor> readFile(String path) {
        ArrayList<Reactor> reactorList = new ArrayList();
        Reactor reactor = null;
        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
        try {
            XMLEventReader reader = xmlInputFactory.createXMLEventReader(new FileInputStream(path));
            while (reader.hasNext()) {
               XMLEvent xmlEvent = reader.nextEvent();
                if (xmlEvent.isStartElement()) {
                    StartElement startElement = xmlEvent.asStartElement();
                    if (startElement.getName().getLocalPart().equals("Reactor")) {
                        reactor = new Reactor();
                    } else if (startElement.getName().getLocalPart().equals("class")) {
                        xmlEvent = reader.nextEvent();
                        reactor.setType(xmlEvent.asCharacters().getData());
                    } else if (startElement.getName().getLocalPart().equals("burnup")) {
                        xmlEvent = reader.nextEvent();
                        reactor.setBurnup(Double.parseDouble(xmlEvent.asCharacters().getData()));
                    } else if (startElement.getName().getLocalPart().equals("kpd")) {
                        xmlEvent = reader.nextEvent();
                        reactor.setKpd(Double.parseDouble(xmlEvent.asCharacters().getData()));
                    } else if (startElement.getName().getLocalPart().equals("enrichment")) {
                        xmlEvent = reader.nextEvent();
                        reactor.setEnrichment(Double.parseDouble(xmlEvent.asCharacters().getData()));
                    } else if (startElement.getName().getLocalPart().equals("thermal_capacity")) {
                        xmlEvent = reader.nextEvent();
                        reactor.setThermalCpacity(Double.parseDouble(xmlEvent.asCharacters().getData()));
                    }else if (startElement.getName().getLocalPart().equals("electrical_capacity")) {
                        xmlEvent = reader.nextEvent();
                        reactor.setElectricalCapacity(Double.parseDouble(xmlEvent.asCharacters().getData()));
                    } else if (startElement.getName().getLocalPart().equals("life_time")) {
                        xmlEvent = reader.nextEvent();
                        reactor.setLifeTime(Integer.parseInt(xmlEvent.asCharacters().getData()));
                    } else if (startElement.getName().getLocalPart().equals("first_load")) {
                        xmlEvent = reader.nextEvent();
                        reactor.setFirstLoad(Double.parseDouble(xmlEvent.asCharacters().getData()));
                    }
            }
                if (xmlEvent.isEndElement()) {
                    EndElement endElement = xmlEvent.asEndElement();
                    if (endElement.getName().getLocalPart().equals("Reactor")) {
                        reactorList.add(reactor);
                        
                    }
                }
           }
        }catch (FileNotFoundException ex) {
              ex.printStackTrace();
        } catch (XMLStreamException ex) {
            Logger.getLogger(XmlReader.class.getName()).log(Level.SEVERE, null, ex);
        }
        return reactorList;
    }
    
    
    @Override
    public DefaultMutableTreeNode buildTree() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
        
}
