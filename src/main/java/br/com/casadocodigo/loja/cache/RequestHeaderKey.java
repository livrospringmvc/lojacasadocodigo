package br.com.casadocodigo.loja.cache;

public class RequestHeaderKey {

	private String header;
	private Object generate;

	public RequestHeaderKey(String header, Object generate) {
		this.header = header;
		this.generate = generate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((generate == null) ? 0 : generate.hashCode());
		result = prime * result + ((header == null) ? 0 : header.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RequestHeaderKey other = (RequestHeaderKey) obj;
		if (generate == null) {
			if (other.generate != null)
				return false;
		} else if (!generate.equals(other.generate))
			return false;
		if (header == null) {
			if (other.header != null)
				return false;
		} else if (!header.equals(other.header))
			return false;
		return true;
	}

}
