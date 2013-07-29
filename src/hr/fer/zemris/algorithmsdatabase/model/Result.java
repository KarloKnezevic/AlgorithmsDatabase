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
@Table(name = "result")
@NamedQueries({ @NamedQuery(name = "Result.list", query = "select r from Result as r", hints = { @QueryHint(name = "org.hibernate.cacheable", value = "true") }) })
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Result {

	private Integer evaluations;

	private Double min;

	private Double max;

	private Double avg;

	private Double stdev;

	private Long runId;

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
		final Result other = (Result) obj;
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
	public Double getAvg() {
		return avg;
	}

	@Column(nullable = false)
	public Integer getEvaluations() {
		return evaluations;
	}

	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}

	@Column(nullable = false)
	public Double getMax() {
		return max;
	}

	@Column(nullable = false)
	public Double getMin() {
		return min;
	}

	@Column(nullable = false)
	public Double getStdev() {
		return stdev;
	}

	@Column(nullable = false)
	public Long getRunId() {
		return runId;
	}

	public void setAvg(Double avg) {
		this.avg = avg;
	}

	public void setEvaluations(Integer evaluations) {
		this.evaluations = evaluations;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setMax(Double max) {
		this.max = max;
	}

	public void setMin(Double min) {
		this.min = min;
	}

	public void setStdev(Double stdev) {
		this.stdev = stdev;
	}

	public void setRunId(Long runId) {
		this.runId = runId;
	}

	@Override
	public String toString() {
		return evaluations + " " + min + " " + max + " " + avg + " " + stdev
				+ " (" + id + ")";
	}

}
