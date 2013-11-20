package be.groept.hibernate.entities.types;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.usertype.UserType;
import org.springframework.util.ObjectUtils;

import com.sun.xml.internal.messaging.saaj.util.Base64;

public class PasswordUserType implements UserType {

	@Override
	public Object nullSafeGet(ResultSet rs, String[] names,
			SessionImplementor session, Object owner)
			throws HibernateException, SQLException {
		if (rs != null) {
			String password = rs.getString(names[0]);
			return new Password(new String(Base64.base64Decode(password)),
					password);
		}
		return null;
	}

	@Override
	public void nullSafeSet(PreparedStatement st, Object value, int index,
			SessionImplementor session) throws HibernateException, SQLException {
		if (value != null) {
			st.setString(
					index,
					new String(Base64.encode(((Password) value).getClearText()
							.getBytes())));
		}
	}

	// -- Helpers
	public Object deepCopy(Object value) throws HibernateException {
		if (value != null) {
			Password p = (Password) value;
			return new Password(p.getClearText(), p.getPassword());
		}
		return null;
	}

	public Serializable disassemble(Object value) throws HibernateException {
		return (Serializable) value;
	}

	public boolean equals(Object x, Object y) throws HibernateException {
		return ObjectUtils.nullSafeEquals(x, y);
	}

	public int hashCode(Object x) throws HibernateException {
		return ObjectUtils.nullSafeHashCode(x);
	}

	public boolean isMutable() {
		return true;
	}

	public Object replace(Object original, Object target, Object owner)
			throws HibernateException {
		return original;
	}

	public Object assemble(Serializable cached, Object owner)
			throws HibernateException {
		return cached;
	}

	public Class<?> returnedClass() {
		return Password.class;
	}

	public int[] sqlTypes() {
		return new int[] { Types.VARCHAR };
	}
}