package edu.eci.arsw.gof.chainofrep.fileproc;

import java.util.logging.Logger;

public class XMLProcessor implements DataProcessingChain {
	
	private DataProcessingChain chain;

	@Override
	public void setNextProcessor(DataProcessingChain nextInChain) {
		chain=nextInChain;

	}

	@Override
	public void proccessData(String extension,Logger LOG) throws DataLoadException {
		if(extension.equals("xml"))
		{
			LOG.info("Processing XML...");
		}else if(chain!=null){
			chain.proccessData(extension,LOG);
		}else{
			throw new DataLoadException("Format not supported: "+extension);
		}

	}


}
