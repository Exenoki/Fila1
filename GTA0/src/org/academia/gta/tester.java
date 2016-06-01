package org.academia.gta;

import org.academia.gta.position.GridType;

/**
 * Created by glitch for <Bashtard$ Bootcamp @ Academia de Código - Fundão 28/05/16.
 */
public class tester {
    public static void main(String[] args) throws InterruptedException {

        Game mygame = new Game(GridType.SIMPLEGFX,950,600,200);
        mygame.init(20,3);

    }
}
