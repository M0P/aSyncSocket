package events;

import java.util.EventObject;

/**
 * Created with IntelliJ IDEA.
 * User: Xenowar
 * Date: 16.11.13
 * Time: 22:42
 * To change this template use File | Settings | File Templates.
 */
public class AcceptanceEvent extends EventObject{
    public AcceptanceEvent(Object source) {
        super(source);
    }
}
