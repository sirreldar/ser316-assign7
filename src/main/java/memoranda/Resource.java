/**
 * Resource.java
 * Created on 04.04.2003, 20:59:24 Alex
 * Package: net.sf.memoranda
 *  
 * @author Alex V. Alishevskikh, alex@openmechanics.net
 * Copyright (c) 2003 Memoranda Team. http://memoranda.sf.net
 */
package main.java.memoranda;
//TASK 2-2 SMELL BETWEEN CLASSES
//added import so that a resource can be constructed directly from an Element instead of using
//a message chain to pass the information
import nu.xom.Element;
/**
 * 
 */
/*$Id: Resource.java,v 1.4 2007/03/20 06:21:46 alexeya Exp $*/
public class Resource {
    
    private String _path = null;	// the path to the file
    private boolean _isInetShortcut = false; // true if Internet shortcut
    private boolean _isProjectFile = false;	// true if file is in project directory 
    /**
     * Constructor for Resource.
     * @param path, the path to the file.
     * @param isInetShortcut, if the resource is a internet shortcut.
     * @param isProjectFile, if file is copied to project directory.
     */
    public Resource(String path, boolean isInetShortcut, boolean isProjectFile) {
        _path = path;
        _isInetShortcut = isInetShortcut;
        _isProjectFile = isProjectFile;
    }
    
    public Resource(String path) {
        _path = path;         
    }
    
    //TASK 2-2 SMELL BETWEEN CLASSES
    //overloaded the constructor to take an element as an argument. This shortened the message chain
    //that was present in ResourceListImpl.java
    public Resource(Element e) {
        _path = e.getAttribute("path").getValue();
        _isInetShortcut = e.getAttribute("isInetShortcut") != null;
        _isProjectFile = e.getAttribute("isProjectFile") != null;    
    }
    
    public String getPath() {
        return _path;
    }
    
    public boolean isInetShortcut() {
        return _isInetShortcut;
    }
    
    public boolean isProjectFile() {
    	return _isProjectFile;
    }

}
