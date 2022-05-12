/**
 * 
 */
package com.abubusoft.kripton.android;

import androidx.annotation.Nullable;
import com.abubusoft.kripton.TypeAdapter;

/**
 * Allows to manage a field of type J as a field of type D. It's usefully for unsupported type.   
 * 
 * @author Francesco Benincasa (info@abubusoft.com)
 *
 * @param <J>
 * 		field type
 * @param <D>
 * 		data format
 */
public interface SqlTypeAdapter<J, D> extends TypeAdapter<J, D> {

	/**
	 * Convert a field value to its string representation. Usually it's done when you use bean property in where conditions.
	 *
	 * @param javaValue the java value
	 * @return the string
	 */
	@Nullable  String toString(@Nullable  J javaValue);
	
}
