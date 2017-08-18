package edu.eci.arsw.gof.chainofrep.fileproc;

import java.util.logging.Logger;

public class JSONProcessor implements DataProcessingChain {

	private DataProcessingChain chain;

	@Override
	public void setNextProcessor(DataProcessingChain nextInChain) {
		chain=nextInChain;

	}

	@Override
	public void proccessData(String extension,Logger LOG) throws DataLoadException {
		if(extension.equals("json"))
		{
			LOG.info("Processing JSON file...");
		}else if(chain!=null){
			chain.proccessData(extension,LOG);
		}else{
			throw new DataLoadException("Format not supported: "+extension);
		}

	}
}
