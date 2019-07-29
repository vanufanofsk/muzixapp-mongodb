package com.stackroute.muzixapp.Service;

import com.stackroute.muzixapp.Domain.Track;
import com.stackroute.muzixapp.Exception.TrackAlreadyExistsException;
import com.stackroute.muzixapp.Exception.TrackNotFoundException;
import com.stackroute.muzixapp.Repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrackServiceImpl implements TrackService {

    TrackRepository trackRepository;
@Autowired
    public TrackRepository getTrackRepository() {
        return trackRepository;
    }

    public TrackServiceImpl(TrackRepository trackRepository)
    {
        this.trackRepository=trackRepository;
    }
    @Override
    public Track saveTrack(Track track)throws TrackAlreadyExistsException {
        if (trackRepository.existsById(track.getId())){
            throw new TrackAlreadyExistsException("Track already exist");
    }
        Track track1= trackRepository.save(track);
        if(track1==null)
        {
            throw new TrackAlreadyExistsException("User Already Exists");
        }
        //Track savedTrack=trackRepository.save(track);
        return track1 ;
    }

    @Override
    public List<Track> getAllTracks() {
        return trackRepository.findAll();
    }

    @Override
    public void deleteTrackById(int id) {
        trackRepository.deleteById(id);

    }

    @Override
    public void deleteAllTrack() {
        trackRepository.deleteAll();
    }

    @Override
    public boolean updateById(int id,Track track) throws TrackNotFoundException {
        Optional<Track> optionalTrack=trackRepository.findById(id);
        if(!optionalTrack.isPresent())
        { throw new TrackNotFoundException("Track not found");
            }

            track.setId(id);
            trackRepository.save(track);
            return true;
    }



}

