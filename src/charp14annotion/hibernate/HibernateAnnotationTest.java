package charp14annotion.hibernate;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.lang.annotation.ElementType;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.Name;
import javax.lang.model.element.TypeElement;
/**
 * 
 * @ClassName:  HibernateAnnotationTest   
 * @Description:和反射获取annotation信息不同：
 * 			annotation处理器RoundEnvironment.getElementsAnnotatedWith(class) 获得需要处理的程序单元element
 * 			element.getEnclosedElements() 获得该element内定义的所有单元 包括 成员变量 构造器 内部类 方法
 * 			element.getKind() 返回element所代表的程序单元  {@link ElementType.class}类  ElementType.Field 成员变量
 * @author: 谢洪伟 
 * @date:   2018年11月12日 上午10:33:02
 */
public class HibernateAnnotationTest extends AbstractProcessor{// 处理注解
	
	//循环处理每个需要处理的程序对象
	@Override
	public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
		PrintStream ps = null;
		//查询 每个 被 Persistent修饰的类
		Set<? extends Element> elementsAnnotates = roundEnv.getElementsAnnotatedWith(Persistent.class);
		for (Element element: elementsAnnotates){
			Name className = element.getSimpleName();// 获得类名
			Persistent persistent = element.getAnnotation(Persistent.class);//获得注解
			try {
				ps = new PrintStream(new FileOutputStream(className+".hbm.xml"));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			
			String table = persistent.table();
			ps.println(table);
			
			for (Element f : element.getEnclosedElements()) {//?
				if (f.getKind() == ElementKind.FIELD) { //只处理成员变量上的 annotation
					
					Id id = f.getAnnotation(Id.class);
					if (id!=null) {
						String column = id.column();
						String type = id.type();
						String generator = id.generator();
						ps.println(column+type+generator);
					}
					
					Property property = f.getAnnotation(Property.class);
					if (property!=null) {
						String column = property.column();
						String type = property.type();
						ps.println(column+type);
					}
				}
			}
		}
		
		return true;
	}

}
