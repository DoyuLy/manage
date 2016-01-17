package com.mtwu.builder;

import java.util.List;

import com.mtwu.builder.core.IBuildeController;
import com.mtwu.builder.core.IBuilder;
import com.mtwu.builder.core.impl.BuildeController;
import com.mtwu.builder.core.impl.Builder;
import com.mtwu.builder.model.Maker;
import com.mtwu.builder.model.TableColumns;
import com.mtwu.builder.util.VelocityUtil;

public class BuilderFactory {
	
	private static BuilderFactory instance = new BuilderFactory();

	/**
	 * 单例 构造方法
	 */	
	private BuilderFactory() {
	}

	/**
	 * 单例 构造方法
	 * @return
	 */
	public static BuilderFactory getinstance() {
		return instance;
	}
	
	public IBuildeController getBuildeController(){
		return new BuildeController();
	}
	
	public IBuilder getBuilder(Maker maker,List<TableColumns> list,VelocityUtil agt){
		return new Builder(maker,list,agt);
	}
}
