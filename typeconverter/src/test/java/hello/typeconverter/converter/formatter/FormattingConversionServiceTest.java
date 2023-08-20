package hello.typeconverter.converter.formatter;

import hello.type.IpPort;
import hello.typeconverter.converter.StringToIntegerConverter;
import hello.typeconverter.converter.StringToIpPortConverter;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.format.support.DefaultFormattingConversionService;

import static org.assertj.core.api.Assertions.assertThat;

public class FormattingConversionServiceTest {

    @Test
    void formattingConversionService() {
        DefaultFormattingConversionService conversionService = new DefaultFormattingConversionService();

        conversionService.addConverter(new StringToIntegerConverter());
        conversionService.addConverter(new StringToIpPortConverter());
        conversionService.addFormatter(new MyNumberFormatter());

        assertThat(conversionService.convert("127.0.0.1:8080", IpPort.class))
                .isEqualTo(new IpPort("127.0.0.1", 8080));

        assertThat(conversionService.convert(1000, String.class))
                .isEqualTo("1,000");

        assertThat(conversionService.convert("1,000", Long.class))
                .isEqualTo(1000L);

    }
}
