package pl.teamxd.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.teamxd.model.response.StandardResponse;
import pl.teamxd.model.response.Type;
import pl.teamxd.service.PlaceService;

import java.time.LocalDate;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/places")
@RequiredArgsConstructor
public class PlaceController {
    private final PlaceService placeService;

    @GetMapping
    public ResponseEntity<StandardResponse> getAll (
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "10") Integer size,
//            @RequestParam(defaultValue = "") String name,
//            @RequestParam(defaultValue = "") String date,
            @RequestParam(defaultValue = "name") String sortBy,
            @RequestParam(defaultValue = "true") Boolean asc
    ) {
        try {
            return ResponseEntity.
                    status(HttpStatus.OK)
                    .body(new StandardResponse(
                            Type.SUCCESS,
                            "Data queried",
                            placeService.getAll(page, size, sortBy, asc)
                        )
                    );

        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.NOT_ACCEPTABLE)
                    .body(new StandardResponse(Type.ERROR, e.toString(), ""));
        }
    }
}
