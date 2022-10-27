//Osamah Alsumaitti
package src;

/**
 * When the requested room is not available, then NotAvailable class is used to throw exception
 */
class NotAvailable extends Exception
{
    @Override
    public String toString()
    {
        return "Not Available !";
    }
}
