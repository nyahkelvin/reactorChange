/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tworope.reactor.change.data;

import com.orientechnologies.orient.core.id.ORecordId;
import com.tinkerpop.blueprints.impls.orient.OrientGraph;
import com.tinkerpop.blueprints.impls.orient.OrientGraphFactory;
import com.tinkerpop.frames.FramedGraph;
import com.tinkerpop.frames.FramedGraphFactory;
import com.tinkerpop.frames.modules.javahandler.JavaHandlerModule;
import com.tworope.reactor.change.dto.ChangeDTO;
import com.tworope.reactor.change.frames.Change;
import com.tworope.reactor.change.util.ReactiveFrame;

/**
 *
 * @author tobah
 */
public class ChangeDAO {

    public boolean saveChange(ChangeDTO changeDTO) {
        OrientGraphFactory factory = new ReactiveFrame().getOrientGraphFactory();
        FramedGraph<OrientGraph> framedGraph = null;
        try {

            OrientGraph graph = factory.getTx();
            framedGraph = new FramedGraphFactory(new JavaHandlerModule()).create(graph);

            Change change = framedGraph.addVertex("class:Change", Change.class);
            
            change.setOldDepartureDate(changeDTO.getOldDepartureDate());
            change.setNewDepartureDate(changeDTO.getNewDepartureDate());
            change.setPenaltyFee(changeDTO.getPenaltyFee());
            change.setChangeDate(changeDTO.getChangeDate());

            graph.commit();

            System.out.println("Change id before save " + change.asVertex().getId());

            return true;

        } catch (Exception e) {
            System.out.println("exception to add Change " + e);
        } finally {
            if (framedGraph != null) {
                framedGraph.shutdown();
            }
        }
        return false;
    }

    public ChangeDTO saveChangeDTO(Change change) {
        
        ChangeDTO changeDTO = new ChangeDTO();
        
        changeDTO.setOldDepartureDate(change.getOldDepartureDate());
        changeDTO.setNewDepartureDate(change.getNewDepartureDate());
        changeDTO.setPenaltyFee(change.getPenaltyFee());
        changeDTO.setChangeDate(change.getChangeDate());
        
        return changeDTO;
    }
    
    public ChangeDTO getAllChanges(){
        
        OrientGraphFactory factory = new ReactiveFrame().getOrientGraphFactory();
        FramedGraph<OrientGraph> framedGraph = null;
        ChangeDTO changeDTO = null;
        
        try {

            OrientGraph graph = factory.getTx();
            framedGraph = new FramedGraphFactory(new JavaHandlerModule()).create(graph);

            ORecordId orid = new ORecordId("#41:0");

            Change change = framedGraph.getVertex(orid, Change.class);

            changeDTO = saveChangeDTO(change);
            System.out.println("Change details " + changeDTO);
            
        } catch (Exception e) {
            System.out.println("exception to retrieve Change " + e);
        } finally {
            if (framedGraph != null) {
                framedGraph.shutdown();
            }
        }
        return changeDTO;
    }
}
