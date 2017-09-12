package com.icona.helper;

import java.io.File;

import com.icona.tree.nodes.PackageDef;

public class FileModel {

	File file;
	PackageDef package_;

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public FileModel(File file, PackageDef package_) {
		this.file = file;
		this.package_ = package_;
	}
	
	public void setPackage(PackageDef package_){
		this.package_ = package_;
	}
	public PackageDef getPackage(){
		return this.package_;
	}
}
