/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.gof.chainofrep.fileproc;

import java.util.logging.Logger;
import org.apache.commons.io.FilenameUtils;

/**
 *
 * @author hcadavid
 */


public class DataProcessor{

    public void loadAndProcessData(String fileName) throws DataLoadException{
        
        LOG.info("Loading data...");
        
        DataProcessingChain p1=new XMLProcessor();
        DataProcessingChain p2=new CSVProcessor();
        DataProcessingChain p3=new JSONProcessor();
        DataProcessingChain p4=new TXTProcessor();
        
        p1.setNextProcessor(p2);
        p2.setNextProcessor(p3);
        p3.setNextProcessor(p4);
        
        p1.proccessData(extension(fileName),LOG);
        
        /*
            DATA PROCESSING CORE
        */
        LOG.info("Processing data...");
        LOG.info("Done. Execution finished.");
    }
    
    public String extension(String fileName){
        return FilenameUtils.getExtension(fileName);
    }
    
    private static final Logger LOG = Logger.getLogger(DataProcessor.class.getName());


}


