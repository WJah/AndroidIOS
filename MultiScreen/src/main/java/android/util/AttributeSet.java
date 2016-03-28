package android.util;

public interface AttributeSet {
    /**
     * Returns the number of attributes available in the set.
     * 
     * @return A positive integer, or 0 if the set is empty.
     */
    public int getAttributeCount();

    /**
     * Returns the name of the specified attribute.
     * 
     * @param index Index of the desired attribute, 0...count-1.
     * 
     * @return A String containing the name of the attribute, or null if the
     *         attribute cannot be found.
     */
    public String getAttributeName(int index);

    /**
     * Returns the value of the specified attribute as a string representation.
     * 
     * @param index Index of the desired attribute, 0...count-1.
     * 
     * @return A String containing the value of the attribute, or null if the
     *         attribute cannot be found.
     */
    public String getAttributeValue(int index);


    /**
     * Return the integer value of 'attribute'.
     * 
     * @param namespace Namespace of attribute to retrieve.
     * @param attribute The attribute to retrieve.
     * @param defaultValue What to return if the attribute isn't found.
     * 
     * @return Resulting value.
     */
    public int getAttributeIntValue(String namespace, String attribute,
                                    int defaultValue);
    
    public String getAttributeStringValue(String namespace, String attribute,
                                          String defaultValue);

}
