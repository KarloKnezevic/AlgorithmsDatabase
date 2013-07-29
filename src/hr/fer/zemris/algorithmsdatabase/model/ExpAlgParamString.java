package hr.fer.zemris.algorithmsdatabase.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.QueryHint;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * 
 * @author Karlo Knezevic, karlo.knezevic@fer.hr
 * 
 */
@Entity
@Table(name = "expalgparamstring")
@NamedQueries({ @NamedQuery(name = "ExpAlgParamString.list", query = "select a from ExpAlgParamString as a", hints = { @QueryHint(name = "org.hibernate.cacheable", value = "true") }) })
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class ExpAlgParamString {

	private String value;

	private Long id;

	private Long expId;

	private Long algParamId;

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final ExpAlgParamString other = (ExpAlgParamString) obj;
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		return true;
	}

	@Column(nullable = false)
	public Long getAlgParamId() {
		return algParamId;
	}

	@Column(nullable = false)
	public Long getExpId() {
		return expId;
	}

	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}

	@Column(nullable = false)
	public String getValue() {
		return value;
	}

	public void setAlgParamId(Long algParamId) {
		this.algParamId = algParamId;
	}

	public void setExpId(Long expId) {
		this.expId = expId;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return value + " (" + id + ")";
	}

}
