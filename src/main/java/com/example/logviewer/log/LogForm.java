package com.example.logviewer.log;

import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
public class LogForm implements Serializable {
    @Size(max=10)
    private String searchText;
}
