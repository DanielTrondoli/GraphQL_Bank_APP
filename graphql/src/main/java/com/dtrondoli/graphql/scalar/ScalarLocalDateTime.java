package com.dtrondoli.graphql.scalar;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Component;

import graphql.language.StringValue;
import graphql.schema.Coercing;
import graphql.schema.CoercingParseLiteralException;
import graphql.schema.CoercingParseValueException;
import graphql.schema.CoercingSerializeException;
import graphql.schema.GraphQLScalarType;

@Component
public class ScalarLocalDateTime extends GraphQLScalarType {
	
	public ScalarLocalDateTime() {
		super("LocalDateTime", "Date type", new Coercing<LocalDateTime, String>() {

			@Override
			public String serialize(Object dataFetcherResult) throws CoercingSerializeException {
				if(dataFetcherResult instanceof LocalDateTime) {
					LocalDateTime date = (LocalDateTime) dataFetcherResult;
					date = LocalDateTime.ofInstant(date.toInstant(ZoneOffset.UTC), ZoneOffset.systemDefault());					
					return date.format(DateTimeFormatter.ISO_DATE_TIME);
				}
				return null;				
			}

			@Override
			public LocalDateTime parseValue(Object input) throws CoercingParseValueException {
				if (input instanceof String) {
					LocalDateTime d = LocalDateTime.parse((String) input, DateTimeFormatter.BASIC_ISO_DATE);
					if (d != null) {
						return d;
					}
				}
				throw new CoercingSerializeException("Invalid Date: " + input);
			}

			@Override
			public LocalDateTime parseLiteral(Object input) throws CoercingParseLiteralException {
				if (!(input instanceof StringValue))
					return null;
				String s = ((StringValue) input).getValue();
				return this.parseValue(s);
			}
			
		});
	}
	
	
}
