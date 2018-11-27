package charp11AWT.draw;

import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.io.Serializable;
/**
 * 
 * @ClassName:  SerialSelection   
 * @Description:	持有一个可 序列化对象 用于传输
 * @author: 谢洪伟 
 * @date:   2018年10月17日 下午2:35:03
 */
public class SerialSelection implements Transferable {
	private Serializable person;
	
	public SerialSelection(Serializable person){
		this.person = person;
	}

	@Override
	public DataFlavor[] getTransferDataFlavors() {
		DataFlavor[] datas = new DataFlavor[2];
		Class clazz = person.getClass();
		try {
			datas[0] = new DataFlavor(DataFlavor.javaSerializedObjectMimeType+";class="+clazz.getName());
			datas[1] = DataFlavor.stringFlavor;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return datas;
	}

	@Override
	public boolean isDataFlavorSupported(DataFlavor dataFlavor) {
		return dataFlavor.equals(DataFlavor.stringFlavor) 
				|| dataFlavor.getPrimaryType().equals("application")
				&& dataFlavor.getSubType().equals("x-java-serialized-object")
				&& dataFlavor.getRepresentationClass().isAssignableFrom(person.getClass());
	}

	@Override
	public Object getTransferData(DataFlavor dataFlavor) throws UnsupportedFlavorException, IOException {
		if (isDataFlavorSupported(dataFlavor)) {
			if (dataFlavor.equals(DataFlavor.stringFlavor)) {
				return person.toString();
			}
			return person;
		}else {
			return null;
		}
	}

}
