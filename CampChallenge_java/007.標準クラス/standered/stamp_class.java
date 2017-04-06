/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pack;

import java.util.Date;

/**
 *
 * @author osakayuto
 */
abstract class stamp_class {
    

    Date date = new Date();
    Date past = new Date();
    abstract Date time();
     abstract String nowTime();
     abstract String timestampViwe();
//     abstract Integer timeDiffelence();

}
