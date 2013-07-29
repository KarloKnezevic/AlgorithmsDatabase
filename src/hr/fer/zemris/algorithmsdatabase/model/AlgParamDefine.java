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
@Table(name = "algparamdefine")
@NamedQueries({ @NamedQuery(name = "AlgParamDefine.list", query = "select a from AlgParamDefine as a", hints = { @QueryHint(name = "org.hibernate.cacheable", value = "true") }) })
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class AlgParamDefine {

	private Long id;

	private Long algId;

	private Long algParId;

	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(nullable = false, length = 10)
	public Long getAlgId() {
		return algId;
	}

	public void setAlgId(Long algId) {
		this.algId = algId;
	}

	@Column(nullable = false, length = 10)
	public Long getAlgParId() {
		return algParId;
	}

	public void setAlgParId(Long algParId) {
		this.algParId = algParId;
	}

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
		final AlgParamDefine other = (AlgParamDefine) obj;
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "(" + id + " [" + algId + ", " + algParId + "])";
	}

}
