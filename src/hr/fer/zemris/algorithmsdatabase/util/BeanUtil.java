package hr.fer.zemris.algorithmsdatabase.util;

import java.lang.reflect.Method;

/**
 * Pomoćni razred koji uporabom Java reflection API-ja omogućava pozivanje
 * metoda nad predanim objektima.
 * 
 * @author Karlo Knezevic, karlo.knezevic@fer.hr
 * 
 */
public class BeanUtil {

	/**
	 * <p>
	 * Pomoćna metoda koja nad objektom poziva setter sa predanom vrijednosti,
	 * ako takav postoji. Ako setter tog tipa ne postoji, metoda ne radi ništa
	 * (ne izaziva iznimku).
	 * </p>
	 * 
	 * <p>
	 * Naziv property-a stvara se iz imena predanog razreda. Npr. ako je ime
	 * prezadnom razreda <code>some.package.ClassName</code>, setter will be
	 * named <code>setClassName</code>. The behavior of this method is then same
	 * as {@linkplain #setPropertyIfPresent(Object, String, Class, Object)}
	 * </p>
	 * 
	 * @param object
	 *            objekt
	 * @param clazz
	 *            razred koji predstavlja tip argumenta
	 * @param value
	 *            vrijednost koju treba predati setteru
	 * @throws Exception
	 *             u slučaju pogreške
	 */
	public static void setPropertyIfPresent(Object object, Class<?> clazz,
			Object value) throws Exception {
		String name = clazz.getName();
		final int index = name.lastIndexOf('.');
		if (index >= 0) {
			name = name.substring(index + 1);
		}
		setPropertyIfPresent(object, "set" + name, clazz, value);
	}

	/**
	 * <p>
	 * Pomoćna metoda koja nad objektom poziva setter sa predanom vrijednosti,
	 * ako takav postoji. Ako setter tog tipa ne postoji, metoda ne radi ništa
	 * (ne izaziva iznimku).
	 * </p>
	 * 
	 * <h2>Primjer poziva</h2>
	 * <p>
	 * Pretpostavimo da imamo objekt <code>x</code> razreda <code>X</code>:
	 * </p>
	 * <code><pre>class X {
	 *   void setSomeType(SomeType value) { ... }
	 * }
	 * 
	 * X x = new X();
	 * </pre></code>
	 * <p>
	 * Uporabom ove metode setter je moguće pozvati ovako:
	 * <p>
	 * <code><pre>
	 * ...
	 * SomeType value = new SomeType();
	 * ...
	 * BeanUtil.setPropertyIfPresent(x, "setSomeType", SomeType.class, value);
	 * </pre></code>
	 * 
	 * @param object
	 *            objekt
	 * @param name
	 *            naziv metode settera koja se treba pozvati
	 * @param clazz
	 *            razred koji predstavlja tip argumenta
	 * @param value
	 *            vrijednost koju treba predati setteru
	 * @throws Exception
	 *             u slučaju pogreške
	 */
	public static void setPropertyIfPresent(Object object, String name,
			Class<?> clazz, Object value) throws Exception {
		Method method = null;
		try {
			method = object.getClass().getMethod(name, new Class[] { clazz });
		} catch (final NoSuchMethodException ignorable) {
			// Ovo je OK; ovaj objekt ne treba
			// zadani property
			return;
		}
		method.invoke(object, new Object[] { value });
	}
}
