/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scctp1;

/**
 *
 * @author MiguelDiogo
 */
public class AnimalMorreuException extends Exception {

    /**
     * Creates a new instance of <code>AnimalMorreuException</code> without
     * detail message.
     */
    public AnimalMorreuException() {
    }

    /**
     * Constructs an instance of <code>AnimalMorreuException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public AnimalMorreuException(String msg) {
        super(msg);
    }
}
