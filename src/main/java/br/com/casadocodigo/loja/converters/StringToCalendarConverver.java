package br.com.casadocodigo.loja.converters;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

import org.springframework.format.AnnotationFormatterFactory;
import org.springframework.format.Formatter;
import org.springframework.format.Parser;
import org.springframework.format.Printer;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.util.StringUtils;

public class StringToCalendarConverver implements
		AnnotationFormatterFactory<DateTimeFormat> {

	@Override
	public Set<Class<?>> getFieldTypes() {
		HashSet<Class<?>> classes = new HashSet<>();
		classes.add(Calendar.class);
		return classes;
	}

	@Override
	public Printer<?> getPrinter(DateTimeFormat annotation, Class<?> fieldType) {
		return new CalendarFormatter(annotation);
	}

	@Override
	public Parser<?> getParser(DateTimeFormat annotation, Class<?> fieldType) {
		return new CalendarFormatter(annotation);
	}

	private static class CalendarFormatter implements Formatter<Calendar>{

		private SimpleDateFormat formatter;

		public CalendarFormatter(DateTimeFormat dateTimeFormat) {
			String pattern = dateTimeFormat.pattern();
			if(!StringUtils.hasText(pattern)){
				pattern = "yyyy-MM-dd";
			}
			formatter = new SimpleDateFormat(pattern);
		}

		@Override
		public Calendar parse(String text, Locale locale) throws ParseException {
			Date date = formatter.parse(text);
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			return calendar;
		}

		@Override
		public String print(Calendar calendar, Locale locale) {			
			return formatter.format(calendar.getTime());
		}

	}

}
