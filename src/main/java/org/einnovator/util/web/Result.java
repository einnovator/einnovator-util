/**
 * 
 */
package org.einnovator.util.web;

import org.einnovator.util.model.ObjectBase;
import org.einnovator.util.model.ToStringCreator;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpStatusCodeException;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Type-Safe Result Wrapper with result value or exception.
 */
public class Result<T> extends ObjectBase {

	protected Boolean error;
	
	protected T result;

	protected Exception exception;
	
	protected HttpStatus status;

	/**
	 * Create instance of {@code Result}.
	 *
	 */
	public Result() {
	}
	
	
	/**
	 * Create instance of {@code Result}.
	 *
	 * @param result a result
	 * @param exception a {@code Exception}
	 */
	public Result(T result, Exception exception) {
		this.result = result;
		this.exception = exception;
		this.error = exception!=null;
		if (exception instanceof HttpStatusCodeException) {
			this.status = ((HttpStatusCodeException)exception).getStatusCode();
		}
	}

	/**
	 * Create instance of {@code Result}.
	 *
	 * @param result a result
	 * @param exception a {@code Exception}
	 * @param error true, if error; if null infer from exception parameter
	 */
	public Result(T result, Exception exception, Boolean error) {
		this.result = result;
		this.exception = exception;
		this.error = error!=null ? error : exception!=null;
		if (exception instanceof HttpStatusCodeException) {
			this.status = ((HttpStatusCodeException)exception).getStatusCode();
		}
	}
	
	/**
	 * Create instance of {@code Result}.
	 *
	 * @param exception a {@code Exception}
	 */
	public Result(Exception exception) {
		this.error = true;
		this.exception = exception;
		if (exception instanceof HttpStatusCodeException) {
			this.status = ((HttpStatusCodeException)exception).getStatusCode();
		}
	}
	
	/**
	 * Create instance of {@code Result}.
	 *
	 * @param value a result or exception
	 * @param error true, if error; if null infer from value parameter (set true if value is exception)
	 */
	@SuppressWarnings("unchecked")
	public Result(Object value, Boolean error) {
		this.error = error;
		if (error) {
			if (value instanceof Exception) {
				this.exception = (Exception)value;
				if (exception instanceof HttpStatusCodeException) {
					this.status = ((HttpStatusCodeException)exception).getStatusCode();
				}
			}
		} else {
			this.result = (T)value;			
		}
	}
	
	// Getters/Setters

	/**
	 * Get the value of property {@code error}.
	 *
	 * @return the error
	 */
	public Boolean getError() {
		return error;
	}

	/**
	 * Get the value of property {@code error}.
	 *
	 * @return the error
	 */
	@JsonIgnore
	public Boolean isError() {
		return Boolean.TRUE.equals(error);
	}
	
	/**
	 * Set the value of property {@code error}.
	 *
	 * @param error the value of property error
	 */
	public void setError(Boolean error) {
		this.error = error;
	}

	/**
	 * Get the value of property {@code result}.
	 *
	 * @return the result
	 */
	public T getResult() {
		return result;
	}

	/**
	 * Set the value of property {@code result}.
	 *
	 * @param result the value of property result
	 */
	public void setResult(T result) {
		this.result = result;
	}

	/**
	 * Get the value of property {@code exception}.
	 *
	 * @return the exception
	 */
	public Exception getException() {
		return exception;
	}

	/**
	 * Set the value of property {@code exception}.
	 *
	 * @param exception the value of property exception
	 */
	public void setException(Exception exception) {
		this.exception = exception;
	}
	
	/**
	 * Set the value of property {@code exception} and {@code status}.
	 *
	 * @param exception the value of property exception
	 * @param status the {@code HttpStatus}
	 */
	public void setExceptionAndStatus(Exception exception, HttpStatus status) {
		this.exception = exception;
		this.status = status;
	}
	
	/**
	 * Set the value of property {@code exception} and {@code status}.
	 *
	 * @param exception the value of property exception
	 * @param status the {@code HttpStatus}
	 */
	@JsonIgnore
	public void setExceptionAndStatus(HttpStatusCodeException exception) {
		this.exception = exception;
		this.status = exception.getStatusCode();
	}
	
	/**
	 * Get the value of property {@code status}.
	 *
	 * @return the status
	 */
	public HttpStatus getStatus() {
		return status;
	}

	/**
	 * Set the value of property {@code status}.
	 *
	 * @param status the value of property status
	 */
	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	// With

	/**
	 * Set the value of property {@code error}.
	 *
	 * @param <T> the type of the wrapped value
	 * @param error the value of property error
	 * @param this {@code Result}
	 */
	public Result<T> withError(Boolean error) {
		this.error = error;
		return this;
	}


	/**
	 * Set the value of property {@code result}.
	 *
	 * @param <T> the type of the wrapped value
	 * @param result the value of property result
	 * @param this {@code Result}
	 */
	public Result<T> withResult(T result) {
		this.result = result;
		return this;
	}


	/**
	 * Set the value of property {@code exception}.
	 *
	 * @param <T> the type of the wrapped value
	 * @param exception the value of property exception
	 * @param this {@code Result}
	 */
	public Result<T> withException(Exception exception) {
		this.exception = exception;
		return this;
	}


	/**
	 * Set the value of property {@code status}.
	 *
	 * @param <T> the type of the wrapped value
	 * @param status the value of property status
	 * @param this {@code Result}
	 */
	public Result<T> withStatus(HttpStatus status) {
		this.status = status;
		return this;
	}
	
	/**
	 * Set the value of property {@code exception} and {@code status).
	 *
	 * @param <T> the type of the wrapped value
	 * @param exception the value of property exception
	 * @param status the {@code HttpStatus}
	 * @return this {@code Result}
	 */
	public Result<T> withExceptionAndStatus(Exception exception, HttpStatus status) {
		this.exception = exception;
		this.status = status;
		return this;
	}
	
	/**
	 * Set the value of property {@code exception} and {@code status).
	 *
	 * @param <T> the type of the wrapped value
	 * @param exception the value of property exception
	 * @param this {@code Result}
	 */
	@JsonIgnore
	public Result<T> withExceptionAndStatus(HttpStatusCodeException exception) {
		this.exception = exception;
		this.status = exception.getStatusCode();
		return this;
	}


	@Override
	public ToStringCreator toString1(ToStringCreator creator) {
		return super.toString1(creator)
				.append("error", error)
				.append("result", result)
				.append("status", status)
				.append("exception", exception)
				;
	}


}
