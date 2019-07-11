package business;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.glassfish.jersey.media.multipart.FormDataParam;
import org.glassfish.jersey.media.multipart.ContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataBodyPart;
import org.glassfish.jersey.media.multipart.FormDataMultiPart;

@Path("/documenti")
public class DocumentoRes {

    private static final String LOCATION = "/home/tss/Scrivania/";

    /*
    @POST
    @Path("/upload")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public Response upload(@FormDataParam("file") InputStream is,
            @FormDataParam("file") ContentDisposition contentDispositionHeader) {

        try {
            Files.copy(is,
                    Paths.get(LOCATION + contentDispositionHeader.getFileName()),
                    StandardCopyOption.REPLACE_EXISTING);

            return Response.ok().build();
        } catch (IOException ex) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }

    }
    */

    
    @POST
    @Path("/upload")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public Response uploadFile(FormDataMultiPart form) {
        try {
            FormDataBodyPart filePart = form.getField("file");
            ContentDisposition contentDispositionHeader =  filePart.getContentDisposition();

            InputStream fileInputStream = filePart.getValueAs(InputStream.class);

            Files.copy(fileInputStream,
                    Paths.get(LOCATION + contentDispositionHeader.getFileName()),
                    StandardCopyOption.REPLACE_EXISTING);
            
            String output = "File saved to server..";
            return Response.ok(output).build();
        } catch (IOException ex) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }

    }

}
