package old.imperial

import org.turnstyles.MajorMap;
import org.turnstyles.Region

class BootStrap {

    def init = { servletContext ->
        MajorMap mainMap = new MajorMap(name: "Sahul")
            .addToRegions("name": "region1")
            .save();
    }
    def destroy = {
    }
}
