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
@Table(name = "experiment")
@NamedQueries({ @NamedQuery(name = "Experiment.list", query = "select e from Experiment as e", hints = { @QueryHint(name = "org.hibernate.cacheable", value = "true") }) })
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Experiment {

	private Long algId;

	private Long probId;

	private Long id;

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
		final Experiment other = (Experiment) obj;
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		return true;
	}

	@Column(nullable = false, length = 10)
	public Long getAlgId() {
		return algId;
	}

	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}

	@Column(nullable = false, length = 10)
	public Long getProbId() {
		return probId;
	}

	public void setAlgId(Long algId) {
		this.algId = algId;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setProbId(Long probId) {
		this.probId = probId;
	}

	@Override
	public String toString() {
		return "Experiment (" + id + " [" + algId + ", " + probId + "])";
	}

}
