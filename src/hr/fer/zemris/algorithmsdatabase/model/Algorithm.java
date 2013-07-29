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
 * Model algoritma.
 * 
 * @author Karlo Knezevic, karlo.knezevic@fer.hr
 * 
 */
@Entity
@Table(name = "algorithm")
@NamedQueries({ @NamedQuery(name = "Algorithm.list", query = "select a from Algorithm as a", hints = { @QueryHint(name = "org.hibernate.cacheable", value = "true") }) })
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Algorithm {

	private String name;

	private String description;

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
		final Algorithm other = (Algorithm) obj;
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		return true;
	}

	@Column(nullable = false, length = 100)
	public String getDescription() {
		return description;
	}

	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}

	@Column(nullable = false, length = 30)
	public String getName() {
		return name;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name + " " + description + " (" + id + ")";
	}

}
