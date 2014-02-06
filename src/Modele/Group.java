/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modele;

/**
 *
 * @author Bakalian
 */
public final class Group {
    
    private int numeroGroup;
    private String namegroup;

    public Group(int numeroGroup, String namegroup) {
        this.numeroGroup = numeroGroup;
        this.namegroup = namegroup;
    }

    public int getNumeroGroup() {
        return numeroGroup;
    }

    public String getNamegroup() {
        return namegroup;
    }

    public void setNumeroGroup(int numeroGroup) {
        this.numeroGroup = numeroGroup;
    }

    public void setNamegroup(String namegroup) {
        this.namegroup = namegroup;
    }
    
        
    
}
