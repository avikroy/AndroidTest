package com.example.a738119.samplepro.Interface

import com.fasterxml.jackson.annotation.JsonProperty

data class PhillipPayBase(@JsonProperty("createdDate")
                     var createdDate: Any,
                     @JsonProperty("createdBy")
                     var createdBy: Any) {
}