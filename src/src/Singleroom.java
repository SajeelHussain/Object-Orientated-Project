//Osamah Alsumaitti
package src;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Sigleroom extends room which is further extended by double room
 */
class Singleroom extends Room implements Serializable
{
    String name;
    String contact;
    String gender;



    Singleroom()
    {
        this.name="";
    }
    Singleroom(String name,String contact,String gender)
    {
        this.name=name;
        this.contact=contact;
        this.gender=gender;
        System.out.println(this.name );
        System.out.println(this.contact );
        System.out.println(this.gender );

    }
}
