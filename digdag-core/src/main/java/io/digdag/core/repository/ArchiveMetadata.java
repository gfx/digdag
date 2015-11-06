package io.digdag.core.repository;

import java.util.Map;
import io.digdag.core.config.Config;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.immutables.value.Value;

@Value.Immutable
@JsonSerialize(as = ImmutableArchiveMetadata.class)
@JsonDeserialize(as = ImmutableArchiveMetadata.class)
public abstract class ArchiveMetadata
{
    public static final String FILE_NAME = ".digdag.yml";

    public abstract WorkflowSourceList getWorkflows();

    public static ImmutableArchiveMetadata.Builder builder()
    {
        return ImmutableArchiveMetadata.builder();
    }

    public static ArchiveMetadata of(WorkflowSourceList workflows)
    {
        return builder()
            .workflows(workflows)
            .build();
    }
}