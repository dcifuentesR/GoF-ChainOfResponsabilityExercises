package edu.eci.arsw.gof.chainofrep.fileproc;

public interface DataProcessingChain {
	
	/**
	 * sets the next processor in the chain
	 * @param nextInChain the next processor
	 */
	public void setNextProcessor(DataProcessingChain nextInChain);
	
	/**
	 * process the file
	 * @param extension the extension of the file to be processed
	 */
	public void proccessData(String extension);

}
