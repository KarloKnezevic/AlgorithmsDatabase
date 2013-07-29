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
@Table(name = "problemparamdefine")
@NamedQueries({ @NamedQuery(name = "ProblemParamDefine.list", query = "select a from ProblemParamDefine as a", hints = { @QueryHint(name = "org.hibernate.cacheable", value = "true") }) })
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class ProblemParamDefine {

	private Long id;

	private Long probId;

	private Long probParId;

	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(nullable = false, length = 10)
	public Long getProbId() {
		return probId;
	}

	public void setProbId(Long probId) {
		this.probId = probId;
	}

	@Column(nullable = false, length = 10)
	public Long getProbParId() {
		return probParId;
	}

	public void setProbParId(Long probParId) {
		this.probParId = probParId;
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
		final ProblemParamDefine other = (ProblemParamDefine) obj;
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
		return "(" + id + " [" + probId + ", " + probParId + "])";
	}

}
