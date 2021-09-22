package io.nellis.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ServerResponse{
    public boolean error;
    public String category;
    public String type;
    public String setup;
    public String delivery;
    public Flags flags;
    public int id;
    public boolean safe;
    public String lang;
}

@Data
@NoArgsConstructor
class Flags{
    public boolean nsfw;
    public boolean religious;
    public boolean political;
    public boolean racist;
    public boolean sexist;
    public boolean explicit;
}

