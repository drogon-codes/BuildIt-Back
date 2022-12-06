package com.buidit.BuildItBack.service;

import com.buidit.BuildItBack.exception.UserNotFoundException;
import com.buidit.BuildItBack.model.Brand;
import com.buidit.BuildItBack.model.Build;
import com.buidit.BuildItBack.repo.BuildRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuildService {
    private final BuildRepo buildRepo;
    @Autowired
    public BuildService(BuildRepo buildRepo) {
        this.buildRepo = buildRepo;
    }
    public Build addBuild(Build build){
        return buildRepo.save(build);
    }

    public List<Build> getAllBuild(){
        return buildRepo.findAll();
    }

    public Build updateBuild(Build build){
        return buildRepo.save(build);
    }

    public void deleteBuild(Integer buildId){
        buildRepo.deleteById(buildId);
    }

    public Build findByBuildId(Integer buildId){
        return buildRepo.findById(buildId).orElseThrow(() -> new UserNotFoundException("Build by id " + buildId + " was not found"));
    }

    public Build findByUserId(Integer userId){
        return buildRepo.findByUserId(userId);
    }

}